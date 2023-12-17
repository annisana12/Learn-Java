package belajar_package.application;

import belajar_package.data.Company;

public class CompanyApp {
    public static void main(String[] args) {
        Company company = new Company();
        company.setName("Google");

        // Cara membuat object dari inner class
        Company.Employee employee = company.new Employee();
        employee.setName("Budi");

        System.out.println(employee.getName());
        System.out.println(employee.getCompany());
    }
}
