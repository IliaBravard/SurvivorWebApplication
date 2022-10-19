package controller; // The package where this converter class is located at

/**
 * @author Ilia Bravard - igbravard
 * CIS175 - Fall 2022
 * Oct 20, 2022
 */

// Including the needed imports
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This class converts the LocalDate field of the 'Seasons' model class to an
 * understandable date data type for SQL. Otherwise, it will be represented as a
 * BLOB object in the actual database. This class also implements an interface
 * to accomplish the given task.
 */

// The annotation used to treat this class as a converter
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	/**
	 * This method converts the value stored in the entity attribute into the data
	 * representation to be stored in the database.
	 * 
	 * @param attribute - the data attribute
	 * @return the data representation of the entity attribute, if any
	 */
	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		return (attribute == null ? null : Date.valueOf(attribute));
	}

	/**
	 * This method converts the attribute to an understandable local data for the
	 * database used.
	 * 
	 * @param dbData - the attribute data to be converted
	 * @return the converted date
	 */
	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		return (dbData == null ? null : dbData.toLocalDate());
	}
}