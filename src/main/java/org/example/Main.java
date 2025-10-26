package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Employee> duplicates = new LinkedList<>();

        for(Employee emp : employees){
            if(emp == null) continue;
            map.put(emp.getId(), map.getOrDefault(emp.getId(), 0) + 1);
        }

        Set<Integer> addedIds = new HashSet<>();
        for(Employee emp : employees){
            if(emp == null) continue;
            if(map.get(emp.getId()) > 1 && !addedIds.contains(emp.getId())){
                duplicates.add(emp);
                addedIds.add(emp.getId());
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees){
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Employee> resultMap = new HashMap<>();

        for(Employee emp : employees){
            if(emp == null) continue;
            countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
            resultMap.putIfAbsent(emp.getId(), emp);
        }
        return resultMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> list = new LinkedList<>();

        for(Employee emp : employees){
            if(emp == null) continue;
            countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
        }

        for(Employee emp : employees){
            if(emp == null) continue;
            if(countMap.get(emp.getId()) == 1){
                list.add(emp);
            }
        }

        return list;
    }
}