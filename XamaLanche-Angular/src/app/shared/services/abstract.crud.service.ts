import {HttpClient} from "@angular/common/http";
import {environment} from '../../../enviroment';

// @Injectable() - Não pode ser injetável, suas filhas serão
export abstract class AbstractCrudService<T> {

    url: string = environment.BASE_URL

    constructor(private http: HttpClient, private urlPrefix: string) {
        this.url = this.url + urlPrefix;
    }

    getAll() {
        return this.http.get<T[]>(`${this.url}`, {observe: 'response'})
    }

    getById(id: string) {
        return this.http.get<T>(`${this.url}/${id}`, {observe: 'response'})
    }

    save(model: T) {
        return this.http.post(`${this.url}`, model, {observe: 'response'})
    }

    update(id: string, model: T) {
        return this.http.put(`${this.url}/${id}`, model, {observe: 'response'})
    }

    delete(id: string) {
        return this.http.delete(`${this.url}/${id}`, {observe: 'response'})
    }
}
