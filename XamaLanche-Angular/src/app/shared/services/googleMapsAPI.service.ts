import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../enviroment';
import {MapsResponse} from '../models/mapsResponse';

@Injectable()
export class GoogleMapsAPIService {

    url: string = 'https://maps.googleapis.com/maps/api/geocode/json?latlng=LAT,LONG&key=API_KEY&enable_address_descriptor=true';
    API_KEY: string = environment.API_MAPS_KEY;

    constructor(private http: HttpClient) {
        this.url = this.url.replace('API_KEY', this.API_KEY);
    }

    getAddress(lat: number, long: number) {
        this.url = this.url.replace('LAT', lat.toString())
            .replace('LONG', long.toString());

        return this.http.get<MapsResponse>(this.url, {observe: 'response'});
    }
}
