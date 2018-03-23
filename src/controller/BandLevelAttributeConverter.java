/*package controller;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BandLevelAttributeConverter implements AttributeConverter<Integer, String> {
        
	@Override
	public String convertToDatabaseColumn(Integer attribute) {
		// TODO Auto-generated method stub
		switch (attribute) {
		case 1:
			return "elementary";
		case 2:
			return "junior high";
		case 3:
			return "high school";
		default:
			throw new IllegalArgumentException("Unknown" + attribute);
		} 
	}

	@Override
	public Integer convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		switch (dbData) {
		case "elementary":
			return 1;
		case "junior high":
			return 2;
		case "high school":
			return 3;
		default:
			throw new IllegalArgumentException("Unknown" + dbData);
		}
	} 	
}
*/