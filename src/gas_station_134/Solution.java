package gas_station_134;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] extra = new int[length];
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            extra[i] = gas[i] - cost[i];
            map.put(i, extra[i]);
            sum += extra[i];
        }

        if (sum < 0) {
            return -1;
        }

        List<Integer> idxList = map.entrySet().stream()
                .sorted(Comparator.<Map.Entry<Integer, Integer>>comparingInt(Map.Entry::getValue).reversed())
                .map(Map.Entry::getKey)
                .toList();

        for (Integer i : idxList) {
            int accumulation = 0;
            for (int j = 0; j < length; j++) {
                int idx = (i + j) % length;
                accumulation += extra[idx];
                if (accumulation < 0) {
                    break;
                }
            }

            if (accumulation >= 0) {
                return i;
            }
        }

        return -1;
    }
}