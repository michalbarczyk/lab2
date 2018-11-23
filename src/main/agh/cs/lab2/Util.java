package agh.cs.lab2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Util {

    public static Map<Vector, HayStack>  listToLinkedHashMap(List<HayStack> hayStacks) {

        Map<Vector, HayStack> map = new LinkedHashMap<>();

        for (HayStack hayStack : hayStacks) {

            map.put(hayStack.getVector(), hayStack);
        }

        return map;
    }
}
