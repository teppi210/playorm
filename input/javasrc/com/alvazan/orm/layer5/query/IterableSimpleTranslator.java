package com.alvazan.orm.layer5.query;

import java.util.Iterator;

import com.alvazan.orm.api.z5api.IndexColumnInfo;
import com.alvazan.orm.api.z8spi.action.IndexColumn;
import com.alvazan.orm.api.z8spi.meta.DboColumnMeta;

public class IterableSimpleTranslator implements Iterable<IndexColumnInfo> {

	private Iterable<IndexColumn> scan;
	private DboColumnMeta info;

	public IterableSimpleTranslator(DboColumnMeta info, Iterable<IndexColumn> scan) {
		this.info = info;
		this.scan = scan;
	}

	@Override
	public Iterator<IndexColumnInfo> iterator() {
		return new SpiIteratorProxy(info, scan.iterator());
	}
	
	private static class SpiIteratorProxy implements Iterator<IndexColumnInfo> {

		private Iterator<IndexColumn> iterator;
		private DboColumnMeta info;
		
		public SpiIteratorProxy(DboColumnMeta info, Iterator<IndexColumn> iterator) {
			this.iterator = iterator;
			this.info = info;
		}

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public IndexColumnInfo next() {
			IndexColumn indCol = iterator.next();
			IndexColumnInfo info = new IndexColumnInfo();
			info.setPrimary(indCol);
			info.setColumnMeta(this.info);
			return info;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("not supported and never will be");
		}
	}
}
