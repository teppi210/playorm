package com.alvazan.orm.layer3.typed;

import java.util.Iterator;

import com.alvazan.orm.api.z5api.IndexColumnInfo;
import com.alvazan.orm.api.z8spi.iter.AbstractCursor;
import com.alvazan.orm.api.z8spi.iter.AbstractIterator;
import com.alvazan.orm.api.z8spi.iter.AbstractCursor.Holder;

public class IterableIndex implements Iterable<byte[]> {

	private AbstractCursor<IndexColumnInfo> cursor;
	public IterableIndex(AbstractCursor<IndexColumnInfo> indice) {
		this.cursor = indice;
	}

	@Override
	public Iterator<byte[]> iterator() {
		cursor.beforeFirst();
		return new IndexIterator(cursor);
	}
	
	private static class IndexIterator extends AbstractIterator<byte[]> {

		private AbstractCursor<IndexColumnInfo> cursor;

		public IndexIterator(AbstractCursor<IndexColumnInfo> cursor) {
			this.cursor = cursor;
		}

		@Override
		public IterHolder<byte[]> nextImpl() {
			Holder<IndexColumnInfo> next = cursor.nextImpl();
			if(next == null)
				return null;
			byte[] key = next.getValue().getPrimary().getPrimaryKey();
			return new IterHolder<byte[]>(key);
		}
	}
}