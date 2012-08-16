package com.alvazan.orm.api.exc;

import java.util.List;


@SuppressWarnings("rawtypes")
public class StorageMissingEntitesException extends NoSqlOrmException {

	private static final long serialVersionUID = 1L;
	private final List foundElements;

	public StorageMissingEntitesException() {
		super();
		foundElements = null;
	}
	public StorageMissingEntitesException(List foundElements, String message, RowNotFoundException e) {
		super(message);
		this.foundElements = foundElements;
	}
	public List getFoundElements() {
		return foundElements;
	}
	
}
