package group3.lms.business;

import java.io.Serializable;
import java.util.List;

import group3.lms.business.entity.Periodical;
import group3.lms.dataaccess.Dao;

/**
 * 
 * @author binhtran
 *
 */
public class PeriodicalDao extends PaperItemDao implements Dao {

	private final static String TABLE_NAME = "periodicals";
	private List<Periodical> periodicals;

	@Override
	public String getName() {
		return TABLE_NAME;
	}

	public Periodical getBookById(String id) {
		for (Periodical p : periodicals) {
			if (id.equals(p.getId().toLowerCase())) {
				return p;
			}
		}

		return null;
	}

	@Override
	public List<?> getAll() {
		return periodicals;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void unpackResultSet(Serializable rs) {
		this.periodicals = (List<Periodical>) rs;
	}
}
