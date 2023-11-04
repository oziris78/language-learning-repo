

#include <iostream>


using namespace std;



bool isNegative(int& parameter) {
	return parameter < 0;
}


void askUser(int& mins, int& sms, int& MBs, int& callPack, int& smsPack, int& intPack) {
	cout << "Please enter how many minutes you used this month in Turkey: ";
	cin >> mins;
	if(isNegative(mins)) {
		cout << "Number of minutes cannot be smaller than 0.\n";
		exit(-1);
	}
		
	cout << "Please enter how many SMSs you sent this month in Turkey: ";
	cin >> sms;
	if(isNegative(sms)) {
		cout << "Number of SMSs cannot be smaller than 0.\n";
		exit(-1);
	}
	
	cout << "Please enter how many MBs you used this month in Turkey: ";
	cin >> MBs;
	if(isNegative(MBs)) {
		cout << "Number of MBs cannot be smaller than 0.\n";
		exit(-1);
	}
		
	cout << "Please specify how many additional packages you bought for calls, SMS and internet in this order: ";
	cin >> callPack >> smsPack >> intPack;
	if(isNegative(callPack)) {
		cout << "Number of additional call packages cannot be smaller than 0.\n";
		exit(-1);
	}
	if(isNegative(smsPack)) {
		cout << "Number of additional SMS packages cannot be smaller than 0.\n";
		exit(-1);
	}
	if(isNegative(intPack)) {
		cout << "Number of additional internet packages cannot be smaller than 0.\n";
		exit(-1);
	}
	
}


int main() {
	int mins = 0, sms = 0, MBs = 0, callPack = 0, smsPack = 0, intPack = 0;
	
	askUser(mins, sms, MBs, callPack, smsPack, intPack);
	cout << "mins: " << mins << ",sms: " << sms << ",MBs: " << MBs << ",callPack: " << callPack << ",smsPack: "
		<< smsPack << ",intPack: " << intPack << endl;
	
	return 0;
}






