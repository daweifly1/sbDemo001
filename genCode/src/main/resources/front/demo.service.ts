import {Injectable, Injector} from '@angular/core';
import {HttpUtilNs, HttpUtilService} from '../infra/http/http-util.service';
import {Observable} from 'rxjs/Observable';
import {map, retry} from 'rxjs/operators';


export namespace ${beanName}ServiceNs {
    import UfastHttpRes = HttpUtilNs.UfastHttpRes;

    export interface ${beanName}ResModel extends HttpUtilNs.UfastHttpRes {
        value: {
            authId: string;
            verifyCode?: string;
            verifyImgUrl: string;
            <#list propertiesList as p>
            ${p.column}: <#if p.jdbcType=="VARCHAR" >string
                <#elseif p.jdbcType=="BIGINT">number
                <#elseif p.jdbcType=="TIMESTAMP">number
                <#elseif p.jdbcType=="DATE">number
                <#elseif p.jdbcType=="DECIMAL">string<else>string</#if>
            </#list>
        };
    }
    export class ${beanName}ServiceClass {
        private http: HttpUtilService;
        public userInfo: any;
        constructor(private injector: Injector) {
            this.http = injector.get(HttpUtilService);
            this.userInfo = {
                username: null
            };
        }
        //DEMO
        public get${beanName}List(filter: { filters: any, pageNum: number, pageSize: number }): Observable<UfastHttpAnyResModel> {
            const config: HttpUtilNs.UfastHttpConfig = {};
            config.gateway = HttpUtilNs.GatewayKey.Ius;
            return this.http.Post('/profile/list', filter, config);
        }
    }
}
@Injectable()
export class UserService extends UserServiceNs.UserServiceClass {
    constructor(injector: Injector) {
        super(injector);
    }
}