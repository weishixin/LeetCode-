class Solution:
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # set1 = set(nums)
        # arr = list(set1)

        nums.sort(reverse=True)
        return nums[k-1]

if __name__=='__main__':
    solution = Solution()
    print(solution.findKthLargest([3,2,3,1,2,4,5,5,6],2))