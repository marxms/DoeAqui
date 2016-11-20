package br.com.doeaqui.util;

import java.util.Calendar;

public class DataUtil {

	public static String dataToString(Calendar data) {

		if (data == null) {

			return "";

		}

		String dd = data.get(Calendar.DAY_OF_MONTH) + "";
		String yyyy = data.get(Calendar.YEAR) + "";
		String mm;

		int mmI = data.get(Calendar.MONTH) + 1;

		if (mmI > 9) {

			mm = (data.get(Calendar.MONTH) + 1) + "";

		} else {

			mm = "0" + (data.get(Calendar.MONTH) + 1) + "";

		}

		return (dd + "/" + mm + "/" + yyyy);

	}

}
