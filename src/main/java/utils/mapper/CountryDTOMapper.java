package utils.mapper;

import DTO.CountryDTO;
import entities.Country;

import java.util.function.Function;

public class CountryDTOMapper implements Function<Country, CountryDTO> {

    @Override
    public CountryDTO apply(Country country) {

        return CountryDTO.builder()
                .id(country.getId())
                .countryName(country.getCountryName())
                .build();
    }

    public Country apply(CountryDTO countryDTO){
        return Country.builder()
                .id(countryDTO.getId())
                .countryName(countryDTO.getCountryName())
                .build();
    }
}
