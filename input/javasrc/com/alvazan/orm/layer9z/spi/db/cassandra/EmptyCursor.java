package com.alvazan.orm.layer9z.spi.db.cassandra;

import com.alvazan.orm.api.z8spi.iter.AbstractCursor;

public class EmptyCursor<T> extends AbstractCursor<T> {

	@Override
	public void beforeFirst() {
	}

	@Override
	public com.alvazan.orm.api.z8spi.iter.AbstractCursor.Holder<T> nextImpl() {
		return null;
	}


}
