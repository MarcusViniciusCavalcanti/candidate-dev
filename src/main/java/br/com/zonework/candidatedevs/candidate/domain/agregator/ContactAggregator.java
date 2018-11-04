package br.com.zonework.candidatedevs.candidate.domain.agregator;

import br.com.zonework.candidatedevs.candidate.domain.entity.Contact;
import br.com.zonework.candidatedevs.candidate.domain.repository.CityRepository;
import br.com.zonework.candidatedevs.candidate.domain.valueObject.City;

public class ContactAggregator {

    public Contact getNewContactWithCity(String cityName, String province, String street) {
        Contact contact = new Contact();

        CityRepository cityRepository = new CityRepository();
        City city = cityRepository.finByNameInProvince(cityName, province).orElse(new City(cityName));
        contact.setCity(city);
        contact.setStreet(street);

        return contact;
    }
}
