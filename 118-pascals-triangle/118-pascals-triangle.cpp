class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        vector<int> temp;
        temp.push_back(1);
        res.push_back(temp);
        if(numRows == 1) return res;
        temp.clear();
        temp.push_back(1);
        temp.push_back(1);
        res.push_back(temp);
        temp.clear();
        if(numRows == 2) return res;
        
        int rowCount = 2;
        while(rowCount < numRows){
            vector<int>temp2(rowCount+1, 0);
            for(int i = 0; i<=rowCount; i++){
                if(i == 0 || i == rowCount)
                    temp2[i] = 1;
                else{
                    temp2[i] = res[rowCount-1][i-1] + res[rowCount-1][i];
                }
            }
            
            res.push_back(temp2);
            rowCount++;
        }
        
        return res;
    }
};