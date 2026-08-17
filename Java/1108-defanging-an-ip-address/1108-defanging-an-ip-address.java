// https://leetcode.com/problems/defanging-an-ip-address/

class Solution {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    // Using String Builder
    public String defangIPaddr2(String address) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                result.append("[.]");
            } else {
                result.append(address.charAt(i));
            }
        }

        return result.toString();
    }
}