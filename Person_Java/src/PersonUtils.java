package _a11709076.Statev;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

abstract class PersonUtils {
	public static Set<MoneyMaker> allAbove (final MoneyMaker[] arr, final Integer threshold){
		Set<MoneyMaker> s = new LinkedHashSet<MoneyMaker>();
		int help = (threshold == null ? 1500 : threshold);
		
		if (arr == null) return s;
		
		for (MoneyMaker m : arr) {
			if(m.makeMoney() > help && m != null) {
				s.add(m);
			}
		}
		
		TreeSet<MoneyMaker> ts = new TreeSet<MoneyMaker>(s);
		s = ts;
		
		return s;
	}
}
