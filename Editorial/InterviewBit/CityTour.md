## Problem Description
There are `A` cities numbered from 1 to `A`. You have already visited `M` cities, the indices of which are given in an array `B` of `M` integers.
If a city with index `i` is visited, you can visit either the city with index `i-1 (i >= 2)` or the city with index `i+1 (i < A)` if they are not already visited.
Eg: if `N = 5` and array `M` consists of `[3, 4]`, then in the first level of moves, you can either visit `2` or `5`.
You keep visiting cities in this fashion until all the cities are not visited.

Link: https://www.interviewbit.com/problems/city-tour/

## Solution Approach:
This question uses the concept of combinatorics. We can see vector `B` as ranges to be arranged, but we also have to select the order in which the elements of a single group is chosen within themselves.

Suppose we have a single group `G1` consisting `N` numbers, so this group can be permuted in 2<sup>N-1</sup> ways(as we can take from either side of the group and keep choosing until there is only one number left). Obviously the left most and right most group can be arranged among themselves in only one possible way.

Now consider another group `G2` of `M` numbers. If we take numbers  from `G1` first and then from `G2`, for each possible way in `G1` we will have 2<sup>M-1</sup> possible ways to arrange numbers of `G2`. Now we have total `N+M` numbers and we can divide them in two group of size `N` and `M` in <sup>N+M</sup>C<sub>M</sub> ways.
So we will have total 2<sup>N-1</sup> x 2<sup>M-1</sup> x <sup>N+M</sup>C<sub>M</sub> ways to arrange numbers of `G1` and `G2` combined.

Now extend this idea further, consider another group `G3` with `K` numbers will join this two group `G1` and `G2`. So numbers of `G3` can be arranged in 2<sup>K-1</sup> ways, and from `N+M+K` numbers we can create `G3` in <sup>N+M+K</sup>C<sub>K</sub> ways, again after creating `G3`, from `N+M` numbers(as we have created `G3` we have `N+M` numbers left) we can create `G2` in <sup>N+M</sup>C<sub>M</sub> ways.

So total number of possible arrangement is <br>
&nbsp;&nbsp;&nbsp;&nbsp;
2<sup>N-1</sup> x 2<sup>M-1</sup> x 2<sup> K-1</sup> x <sup>N+M+K</sup>C<sub>K</sub> x <sup>N+M</sup>C<sub>M</sub> <br>
&rarr; 2<sup>N-1</sup> x 2<sup>M-1</sup> x <sup>N+M</sup>C<sub>M</sub> x 2<sup> K-1</sup> x <sup>N+M+K</sup>C<sub>K</sub>  <br>
&rarr; 2<sup>N-1</sup> x <sup>N</sup>C<sub>N</sub> x 2<sup>M-1</sup> x <sup>N+M</sup>C<sub>M</sub> x 2<sup> K-1</sup> x <sup>N+M+K</sup>C<sub>K</sub>  <br>

Can we see a pattern??? :mag_right: