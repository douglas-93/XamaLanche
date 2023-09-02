import {Directive, Injector, Input} from "@angular/core";
import {Observable} from "rxjs";
import {AbstractCrudService} from "../services/abstract.crud.service";
import {HttpClient} from "@angular/common/http";
import {BaseComponent} from "./base.crud";
import notify from "devextreme/ui/notify";

@Directive()
export abstract class AbstractCrud<T,F> extends BaseComponent{

    @Input()
    filter:F;

    @Input()
    model:T;

    dataSource: T[] = [];

    http: HttpClient

    getFilter(): any {
        return this.filter;
    }

    setFilter(f: F) {
        this.filter = f;
    }

    getModel(): any {
        return this.model;
    }

    setModel(m: T) {
        this.model = m;
    }

    getDataSource(): T[] {
        return this.dataSource;
    }


    /** ----------- INICIO DE METODOS ----------- */


    /** Metodo chamado antes da execução do save,
     * Pode ser usado para alterar algum dado do model antes de invocar o save*/

    beforeDoSave(): Observable<any> | null {
        return null;
    }

    /** Metodo chamado depois da execução do save,*/
    afterDoSave() {

    }

    /** Metodo chamado para o Save */
    doSave(model:any) {
        this.beforeDoSave();
        if(this.validateSave()){
            this.getMainService().save(model).subscribe(res => {
                if (res.ok) {
                    notify('Salvo com sucesso', 'success', 3000);
                }
                return res;
            },error => {
                notify('Algo deu errado ao tentar salvar', 'error', 3000);
                return error;

            })
        }
    }

    /** Metodo chamado depois do beforeSave e antes da execução do Save */

    validateSave():Boolean{
        return true;
    }


    /** Metodo chamado antes da execução do filtro */

    beforeDoFilter() {

    }

    /** Metodo chamado apos a execução do filtro */
    afterDoFilter() {

    }

    /** Metodo de Filtro onde contem o beforeDoFilter antes da execução */

    doFilter(){
        this.beforeDoFilter();
        return this.getMainService().getAll().subscribe(res => {
            if(res.body){
                this.dataSource = res.body
            }

        });
    }

    /** Metodo do botao Clear */
    doClear(){

    }




    /** ----------- METODO PRINCIPAL ----------- */

    /** Metodo onde recebera o service da classe que extende e
     * fara sera responsavel por executar os metodos criados acima */

    public getMainService(){
        return new AbstractCrudService<T,F>(this.http,`/${this.urlPrefix}`);
    }



    /** ----------- Construtor ----------- */


    constructor( private _injector:Injector,
                 private urlPrefix:string) {
        super(_injector)
    }
}
