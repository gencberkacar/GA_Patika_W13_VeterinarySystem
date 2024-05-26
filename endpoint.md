## Animal

| Endpoint                       | Method | Description                   |
|--------------------------------|--------|-------------------------------|
| `/animal/getAll`               | GET    | List all animals              |
| `/animal/getByAnimalId/{id}`   | GET    | Get animal by Id              |
| `/animal/save`                 | POST   | Add new animal                |
| `/animal/update`               | PUT    | Update animal record          |
| `/animal/delete/{id}`          | DELETE | Delete animal record          |
| `/animal/getByCustomerId/{id}` | GET    | Animal listing by customer id |

## Customer

| Endpoint                      | Method | Description            |
|-------------------------------|--------|------------------------|
| `/customer/get`              | GET    | List all customers     |
| `/customer/getById/{id}`     | GET    | Get customer by Id     |
| `/customer/getByName/{name}` | GET    | Get customer by name   |
| `/customer/getPets/{id}`     | GET    | Get pets of customer   |
| `/customer/add`               | POST   | Add new customer       |
| `/customer/update`           | PUT    | Update customer record |
| `/customer/delete/{id}`      | DELETE | Delete customer record |

## Doctor

| Endpoint                   | Method | Description          |
|----------------------------|--------|----------------------|
| `/doctor/getAll`           | GET    | List all doctor      |
| `/doctor/getByName/{name}` | GET    | Get doctor by name   |
| `/doctor/save`             | POST   | Add new doctor       |
| `/doctor/update`           | PUT    | Update doctor record |
| `/doctor/delete/{id}`      | DELETE | Delete doctor record |

## Available Day

| Endpoint             | Method | Description                        |
|----------------------|--------|------------------------------------|
| `/date/getAll`       | GET    | List all doctor available days     |
| `/date/getByID/{id}` | GET    | Get doctor available day by Id     |
| `/date/save`         | POST   | Add new doctor available day       |
| `/date/update`       | PUT    | Update doctor available day record |
| `/date/delete/{id}`  | DELETE | Delete doctor available day record |

## Vaccine

| Endpoint                                | Method | Description                   |
|-----------------------------------------|--------|-------------------------------|
| `/vaccine/get`                          | GET    | List all vaccines             |
| `/vaccine/getById/{id}`                 | GET    | Get vaccine by Id             |
| `/vaccine/add`                          | POST   | Add new vaccine               |
| `/vaccine/update`                       | PUT    | Update vaccine record         |
| `/vaccine/delete/{id}`                  | DELETE | Delete vaccine record         |
| `/vaccine/getBetween?startDate?endDate` | GET    | Vaccine listing by date range |
| `/vaccine/getAnimalVaccine/{id}`        | GET    | Listing vaccines by animal id |

## Appointment

| Endpoint                            | Method | Description                                           |
|-------------------------------------|--------|-------------------------------------------------------|
| `/appointment/getAll`               | GET    | List all appointments                                 |
| `/appointment/getById/{id}`         | GET    | Get appointment by Id                                 |
| `/appointment/getByAnimalIdBetween` | GET    | Get all appointments by animal between dates enquired |
| `/appointment/getByDoctorIdBetween` | GET    | Get all appointments by doctor between dates enquired |
| `/appointment/save"`                | POST   | Add new appointment                                   |
| `/appointment/update"`              | PUT    | Update appointment record                             |
| `/appointment/delete/{id}"`         | DELETE | Delete appointment record                             |









