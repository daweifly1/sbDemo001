export interface ${beanName}ReqModel {
    <#list propertiesList as p>
        //${p.comment}
        ${p.property}?: <#if p.jdbcType=="BIGINT"> number<#elseif p.jdbcType=="INTEGER"> number<#elseif p.jdbcType=="TIMESTAMP">Date<#elseif p.jdbcType=="VARCHAR">string<#elseif p.jdbcType=="DECIMAL"> number<#else>any</#if>;
    </#list>
}

##############################################################################################

import { Injectable, Injector } from '@angular/core';
import { HttpUtilNs, HttpUtilService } from '../infra/http/http-util.service';
import { Observable } from 'rxjs/Observable';
export namespace ${beanName}ServiceNs {
    export interface UfastHttpResT<T> extends HttpUtilNs.UfastHttpResT<T> {
    }
    export class ${beanName}ServiceClass {
        private http: HttpUtilService;
        private defaultConfig: HttpUtilNs.UfastHttpConfig;
        private barcodeFlagList: { value: number, label: string }[];
        private returnState: { value: number, label: string }[];
        constructor(private injector: Injector) {
            this.http = this.injector.get(HttpUtilService);
            this.defaultConfig = {
                gateway: HttpUtilNs.GatewayKey.Ss
            };
            this.barcodeFlagList = [
                { label: '否', value: 0 },
                { label: '是', value: 1 }
            ];
        }
        public getBarcodeList(): Observable<any> {
            return Observable.of(this.barcodeFlagList);
        }

        /**列表 */
        public get${beanName}List(filter): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/${fistLowerBeanName}/list', filter, this.defaultConfig);
        }

        /**新增保存 */
        public addSave${beanName}(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/${fistLowerBeanName}/save', data, this.defaultConfig);
        }
        /**新增提交 */
        public addSubmit${beanName}(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/${fistLowerBeanName}/submit', data, this.defaultConfig);
        }
        /**详情 */
        public get${beanName}Detail(id: string): Observable<UfastHttpResT<any>> {
            return this.http.Get<UfastHttpResT<any>>('/${fistLowerBeanName}/item', { id: id }, this.defaultConfig);
        }
        /**结单 */
        public finish${beanName}(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/${fistLowerBeanName}/endBill', data, this.defaultConfig);
        }
        /**删除 */
        public deletePurchaseOut(ids: any[]): Observable<UfastHttpResT<any>> {
            return this.http.Post('/${fistLowerBeanName}/delete', ids, this.defaultConfig);
        }
    }
}

@Injectable()
export class ${beanName}Service extends ${beanName}ServiceNs.${beanName}ServiceClass {
    constructor(injector: Injector) {
        super(injector);
    }
}

###########################################################################################

