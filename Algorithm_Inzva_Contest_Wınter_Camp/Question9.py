# Practice makes it perfect
# inzva community built algoleague for every algorithm enthusiast hungry 
# for self-improvement and friendly competition. Have fun and good luck!

def main():
    n, m = map(int, input().split())
    pred = 0
    arr = list(map(int, input().split()))
    preds = list(map(int, input().split()))
    
    for i in range(m):
        pred = preds[i]
        if subset_sum_exists(arr, pred):
            print("yes")
        else:
            print("no")


def subset_sum_exists(nums, target):
    n = len(nums)
    dp = [[False] * (target + 1) for _ in range(n + 1)]

    for i in range(n + 1):
        dp[i][0] = True

    for i in range(1, n + 1):
        for j in range(1, target + 1):
            if nums[i - 1] <= j:
                dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i - 1]]
            else:
                dp[i][j] = dp[i - 1][j]

    return dp[n][target]


if __name__ == "__main__":
    main()