package com.devi.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountApp {


    /**
     * 自定义Mapper处理类
     */
    public static class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

        LongWritable one = new LongWritable(1);

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            String line = value.toString(); // 接收到的每一行数据
            String[] words = line.split("\t"); //按照指定的分隔符进行拆分

            for (String word : words) {
                context.write(new Text(word), one); //通过上下文把map的处理结果输出
            }

        }
    }

    /**
     * 自定义Reducer处理类
     */
    public static class MyReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
            long sum = 0;

            for (LongWritable value : values) {
                sum += value.get();  //求出现的总数
            }

            context.write(key, new LongWritable(sum)); //最终统计结果的输出
        }
    }

    /**
     * 自定义Driver，封装MapReduce作业的所有信息
     */
    public static void main(String[] args) throws Exception {

        //创建Configuration
        Configuration configuration = new Configuration();

        //创建Job
        Job job = Job.getInstance(configuration, "wordcount");

        //设置job的处理类
        job.setJarByClass(WordCountApp.class);

        //设置作业处理的输入路径
        FileInputFormat.setInputPaths(job, new Path(args[0]));

        //设置map相关的
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        //设置reduce相关的
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        //设置作业处理的输出路径
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        boolean result = job.waitForCompletion(true);

        System.exit(result ? 0 : 1);
    }


}
