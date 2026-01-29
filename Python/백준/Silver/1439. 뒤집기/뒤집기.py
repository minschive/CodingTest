S = input().strip()

count_to_all_zero = 0
count_to_all_one = 0

if S[0] == '0':
    count_to_all_one += 1
else:
    count_to_all_zero += 1

for i in range(len(S) - 1):
    if S[i] != S[i + 1]:
        if S[i + 1] == '1':
            count_to_all_zero += 1
        else:
            count_to_all_one += 1

print(min(count_to_all_zero, count_to_all_one))