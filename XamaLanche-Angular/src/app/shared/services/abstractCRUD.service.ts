import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AbstractCRUDService<T> {

    url: string = 'http://localhost:8080/'

    constructor(path: string,
                private http: HttpClient) {
        this.url = this.url + path
    }

    getAll() {
        return this.http.get<T[]>(`${this.url}/`, {observe: 'response'})
    }

    getById(id: string) {
        return this.http.get<T>(`${this.url}/${id}`, {observe: 'response'})
    }

    save(model: T) {
        return this.http.post(`${this.url}/`, model, {observe: 'response'})
    }

    update(id: string, model: T) {
        return this.http.put(`${this.url}/${id}`, model, {observe: 'response'})
    }

    delete(id: string) {
        return this.http.delete(`${this.url}/${id}`, {observe: 'response'})
    }
}
