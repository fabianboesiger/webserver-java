package database.templates;

import java.util.Map;

import database.Database;
import database.Messages;

public class IntegerTemplate extends PrimitiveTemplate implements Identifiable {
	
	private Integer value;
	private transient Integer minimum;
	private transient Integer maximum;
	private transient boolean notNull;
	
	public IntegerTemplate(String name, Integer minimum, Integer maximum, boolean notNull) {
		super(name);
		this.minimum = minimum;
		this.maximum = maximum;
		this.notNull = notNull;
	}
	
	public IntegerTemplate(String name, Integer minimum, Integer maximum) {
		this(name, minimum, maximum, true);
	}
	
	public IntegerTemplate(String name) {
		this(name, null, null);
	}

	@Override
	public boolean validate(Messages messages) {
		boolean valid = true;
		if(value == null) {
			if(notNull) {
				valid = false;
				messages.add(name, "not-initialized");
			}
		} else {
			if(minimum != null) {
				if(value < minimum) {
					valid = false;
					messages.add(name, "minimum-exceeded");
				}
			}
			if(maximum != null) {
				if(value > maximum) {
					valid = false;
					messages.add(name, "maximum-exceeded");
				}
			}
		}
		return valid;
	}

	@Override
	public void set(Object object) {
		value = (Integer) object;
	}

	@Override
	public Object get() {
		return value;
	}

	@Override
	public String getId() {
		return value.toString();
	}

	@Override
	public String render(Database database) {
		return value.toString();
	}

	@Override
	public void parse(Database database, String string, Map <String, ObjectTemplate> initialized) {
		value = Integer.parseInt(string);
	}
	
}
