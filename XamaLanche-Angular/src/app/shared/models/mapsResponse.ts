export type MapsResponse = {
    plus_code: {
        compound_code: string
        global_code: string
    }
    results: Array<{
        address_components: Array<{
            long_name: string
            short_name: string
            types: Array<string>
        }>
        formatted_address: string
        geometry: {
            location: {
                lat: number
                lng: number
            }
            location_type: string
            viewport: {
                northeast: {
                    lat: number
                    lng: number
                }
                southwest: {
                    lat: number
                    lng: number
                }
            }
            bounds?: {
                northeast: {
                    lat: number
                    lng: number
                }
                southwest: {
                    lat: number
                    lng: number
                }
            }
        }
        place_id: string
        plus_code?: {
            compound_code: string
            global_code: string
        }
        types: Array<string>
    }>
    status: string
}
