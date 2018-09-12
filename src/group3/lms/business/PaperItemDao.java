package group3.lms.business;

import java.util.List;

import group3.lms.business.entity.PaperItem;
import group3.lms.business.entity.PaperItemCopy;

public abstract class PaperItemDao {

	public boolean isAvailable(PaperItem item) {
		List<? extends PaperItemCopy> copies = item.getCopies();
		for (PaperItemCopy pic : copies) {
			if (pic.getCe() == null) {
				return true;
			}
		}

		return false;
	}
}
