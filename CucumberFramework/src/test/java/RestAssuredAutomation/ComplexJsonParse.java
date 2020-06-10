package RestAssuredAutomation;

import File.PayLoad;
import File.ReusableMethod;
import io.restassured.path.json.JsonPath;
//import junit.framework.Assert;

public class ComplexJsonParse {

	public static void main(String[] args) {

		JsonPath Js1 = ReusableMethod.rawToJson(PayLoad.bookResponse());
		// Print No of courses returned by API

		int Count = Js1.getInt("courses.size()");
		System.out.println(Count);
		// Print Purchase Amount
		int PurchaseAmt = Js1.getInt("dashboard.purchaseAmount");
		System.out.println(PurchaseAmt);
		// Print Title of the first course
		String firstBookTitle = Js1.getString("courses[0].title").toString();
		// System.out.println(firstBookTitle);
		// Print All course titles and their respective Prices
		for (int i = 0; i < Count; i++) {
			System.out.println(Js1.getString("courses[" + i + "].title").toString());
			System.out.println(Js1.getString("courses[" + i + "].price").toString());
		}
		// Print no of copies sold by RPA Course
		for (int i = 0; i < Count; i++) {
			if (Js1.getString("courses[" + i + "].title").toString().equals("RPA")) {
				System.out.println("Print no of copies sold by RPA Course");
				System.out.println(Js1.getString("courses[" + i + "].title").toString());
				System.out.println(Js1.getString("courses[" + i + "].price").toString());
				break;
			}

		}

		// Verify if Sum of all Course prices matches with Purchase Amount
		int sum = 0;
		for (int i1 = 0; i1 < Count; i1++) {
			int Copy = Js1.getInt("courses[" + i1 + "].copies");
			int Prices = Js1.getInt("courses[" + i1 + "].price");
			sum = sum + Copy * Prices;

		}
		System.out.println("Sumof the total Book Sold:" + sum);
	//	Assert.assertEquals(PurchaseAmt, sum);

	}

}
