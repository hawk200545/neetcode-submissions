class Solution {
public:
    char delim = '€';
    string encode(vector<string>& strs) {
        string ans = "";
        for (string s : strs){
            for (char c : s) ans += c+1;
            ans += delim;
        }
        return ans;
    }

    vector<string> decode(string s) {
        vector<string>ans;
        string st = "";
        for (int i = 0;i<s.size();i++){
            if (s[i] == delim){
                ans.push_back(st);
                st = "";
            }
            else st += s[i]-1; 
        }
        return ans; 
    }
};
