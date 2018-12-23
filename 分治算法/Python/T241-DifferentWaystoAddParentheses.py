class Solution:

    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        #cache 用来存放已经计算的值
        def dfs(str , cache):
            #定义字符操作字典
            ops = {'+' : lambda x,y:x+y , '-':lambda x,y:x-y , '*': lambda x,y:x*y}
            if not str in cache:
                res = []
                for k, v in enumerate(str):
                    if v in '+-*':
                        for left in dfs(str[:k] , cache):
                            for right in dfs(str[k+1:] , cache):
                                res.append(ops[v](left,right))
                if not res:
                    res.append(int(str))
                cache[str] = res

            return cache[str] #返回此结果

        #下面调用dfs的input方法
        return dfs(input,{})

if __name__=='__main__':
    solution =  Solution()
    print(solution.diffWaysToCompute('2-1-1'))



