package com.devi.tool.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTest {

    public static void main(String[] args) throws Exception {
        //创建测试表和数据
        initDatabase();

        //创建两个线程同时操作同一条记录
        OptimisticThread ot1 = new OptimisticThread(newConnection(), "QQ1");
        OptimisticThread ot2 = new OptimisticThread(newConnection(), "PP2");

        ot1.start();
        ot2.start();
    }

    public static Connection newConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        return con;
    }

    public static void initDatabase() throws Exception {
        Connection con = newConnection();
        Statement stmt = con.createStatement();
        stmt.execute("drop table if exists locktest");
        stmt.execute("create table locktest( name varchar(10)) ENGINE=InnoDB");
        stmt.executeUpdate("insert into locktest values('XJD')");
        con.close();
    }

    public static class OptimisticThread extends Thread {
        Connection con;
        String name;

        public OptimisticThread(Connection con, String name) {
            this.con = con;
            this.name = name;
        }

        @Override
        public void run() {
            doWork(con, name);
        }

        private void doWork(Connection con, String name) {
            try {
                //设置事务级别为可重复读
                this.con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
                this.con.setAutoCommit(false); //开始事务
                System.out.println("Started Transaction...: " + name);

                Statement stmt = this.con.createStatement();

                //先查询一下是否有'XJD'的记录
                ResultSet rs = stmt.executeQuery("select * from locktest where name='XJD'");
                if (rs.next()) {
                    System.out.println("Got Record: " + name + " value: " + rs.getString(1));
                }
                rs.close();

                Thread.sleep(5000);//暂停5s让另一个线程也查询完成

                //更新'XJD'的记录
                int i = stmt.executeUpdate("update locktest set name = '" + name + "' where name = 'XJD'");
                System.out.println("Update Record: " + name + " count: " + i);//更新成功后i为1

                Thread.sleep(5000);//暂停5s让另一个线程也作更新操作

                //查询更新后的记录
                rs = stmt.executeQuery("select * from locktest where name='" + name + "'");
                if (rs.next()) {
                    System.out.println("Got Record: " + name + " value: " + rs.getString(1));
                }
                rs.close();
                //查询原来的记录
                rs = stmt.executeQuery("select * from locktest where name='XJD'");
                if (rs.next()) {
                    System.out.println("Got Record: " + name + " value: " + rs.getString(1));
                }
                rs.close();

                Thread.sleep(10000);

                System.out.println("Commiting Transaction...: " + name);
                this.con.commit();
                this.con.close();

            } catch (SQLException e) {
                System.out.println("Exception in " + name + ": " + e);
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
