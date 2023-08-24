package gas_station_134;

class SolutionReference {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0;
        int total = 0;
        int accumulation = 0;

        for (int i = 0; i < gas.length; i++) {
            int extra = gas[i] - cost[i];
            accumulation += extra;
            total += extra;
            if (accumulation < 0) {
                accumulation = 0;
                res = i + 1;
            }
        }

        if (total < 0) {
            return -1;
        }

        return res;
    }
}