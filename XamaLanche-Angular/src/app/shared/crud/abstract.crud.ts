import {Directive, Injector, Input, ViewChild} from "@angular/core";
import {CrudComponent} from "../components/base-crud/crud.component";
import {Observable} from "rxjs";
import {AbstractCrudService} from "../services/abstract.crud.service";
import {HttpClient} from "@angular/common/http";
import {BaseComponent} from "./base.crud";

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
  doSave(model:any){
    this.beforeDoSave();
    this.getMainService().save(model).subscribe(res =>{
      return res
    });
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
