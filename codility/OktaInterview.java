package com.codility;

// you can also use imports, for example:
// import java.util.*;

public class Solution {
//Employee employee = database.query("SELECT * FROM Employee WHERE employeeId = " + someValue);

    public Employee getEmployee(int id) throws Exception {
        Employee employee = database.query("SELECT * FROM Employee WHERE employeeId = " + id);
        if(employee != null) {
            return employee;   
        } else {
            throw new NotFoundException("No employee found");
        }
    }
    

    public int getAllAtiveEmployees(Date sinceDate) {
        List<Employee> activeEmployees = database.query("SELECT count(id) FROM Employee WHERE hireDate >"+ sinceDate);
        return activeEmployees;
    }

    public int[] getActiveEmployeesByMonth(int comparableEmployeeId) {
        Employee e = getEmployee(comparableEmployeeId);
        List<Employee> activeEmployees = this.getAllAtiveEmployees(e.getHireDate());
        
        Date today = Date.now();
        Date start = e.hireDate();
        int[] counts = new int[(today.getMonth() - start.getMonth())];
        int idx=0;
        while(start < today) {
            counts[idx] = activeEmployees.stream().filter(ae->ae.getHireDate() == start && ae.getTerminateDate() == null).count();
            idx++;
            start = start.addMonth(1);
        }        
    }


    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
    }
    
}
