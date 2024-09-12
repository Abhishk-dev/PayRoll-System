# PayRoll-System
This payroll system adds, removes, and displays employees, calculates salaries for full-time and part-time types, and manages employee data dynamically using OOP principles like inheritance and polymorphism.

This mini project demonstrates the core principles of Object-Oriented Programming (OOP) through a simple payroll management system. The key OOP concepts highlighted in this project are **Abstraction**, **Encapsulation**, **Inheritance**, and **Polymorphism**.

### Key OOP Principles and Their Usage

1. **Abstraction**:
   - **What It Is**: Abstraction is the concept of hiding complex implementation details and showing only the necessary features of an object. It helps in focusing on what an object does instead of how it does it.
   - **How It's Used**: 
     - The `Employee` class is declared as an abstract class. It provides an abstract method `calculateSalary()`, which does not have an implementation. This method represents a common behavior for all types of employees (like full-time or part-time), but the exact implementation details are hidden in this class. The specific calculation is delegated to subclasses (`FullTimeEmployee` and `PartTimeEmployee`).
     - This way, the abstraction allows us to define a common template (or contract) for all employee types without needing to know the specifics of each.

2. **Encapsulation**:
   - **What It Is**: Encapsulation is the bundling of data (attributes) and methods (functions) that operate on the data into a single unit or class. It restricts direct access to some of an object’s components, which is essential for protecting the integrity of the data.
   - **How It's Used**:
     - The `Employee` class encapsulates the properties `name` and `id` by making them private. Access to these fields is provided through public getter methods (`getName()` and `getId()`). 
     - Similarly, the salary calculation is encapsulated within each subclass (`FullTimeEmployee` and `PartTimeEmployee`), ensuring that the details of how a salary is calculated are hidden from other classes.
     - The `PayrollSystem` class encapsulates the management of employees, providing methods to add, remove, and display employees, without exposing the internal `ArrayList<Employee>` directly.

3. **Inheritance**:
   - **What It Is**: Inheritance is a mechanism where a new class (subclass or derived class) inherits properties and behavior from an existing class (superclass or base class). This promotes code reuse and establishes a natural hierarchy.
   - **How It's Used**:
     - `FullTimeEmployee` and `PartTimeEmployee` classes both inherit from the abstract `Employee` class. They reuse the common properties (`name`, `id`) and behavior (like the `toString()` method) from `Employee`, and provide their specific implementation for `calculateSalary()`.
     - By extending the `Employee` class, both subclasses avoid code duplication and maintain a consistent interface (`calculateSalary()`) for different types of employees.

4. **Polymorphism**:
   - **What It Is**: Polymorphism allows objects to be treated as instances of their parent class, enabling the same method to behave differently based on the object's actual class. This supports flexibility and the use of a common interface.
   - **How It's Used**:
     - The `PayrollSystem` class operates on a list of `Employee` objects (`ArrayList<Employee>`). It doesn't need to know the specific type of employee (full-time or part-time); it just treats all of them as `Employee` objects. This is possible because both `FullTimeEmployee` and `PartTimeEmployee` are polymorphically treated as `Employee` objects.
     - When `calculateSalary()` is called on any `Employee` object, Java's runtime polymorphism ensures that the correct method implementation is called based on the actual object type (`FullTimeEmployee` or `PartTimeEmployee`).

### How the Code Works Together

1. **Employee Management**:
   - The `PayrollSystem` class manages a list of employees (`employeeList`). Employees can be added or removed from this list using the `addEmployee()` and `removeEmployee()` methods, respectively. 

2. **Adding Employees**:
   - In the `main()` method, instances of `FullTimeEmployee` and `PartTimeEmployee` are created with specific names, IDs, and salary details. These instances are added to the `PayrollSystem` object (`payrollSystem`) using the `addEmployee()` method.

3. **Displaying Employees**:
   - The `displayEmployees()` method of `PayrollSystem` iterates over the list of employees and prints each employee's details. This invokes the overridden `toString()` method from the `Employee` class, which includes calling `calculateSalary()` to compute the employee's salary dynamically based on their type.

4. **Removing Employees**:
   - The `removeEmployee(int id)` method searches for an employee by their ID in the list and removes them if found. This demonstrates encapsulation by managing the list internally and exposing a controlled way to modify it.

### Overall Functionality

- The mini project creates a payroll management system that can handle both full-time and part-time employees, calculate their salaries, and manage the list of employees dynamically. 
- It showcases how OOP principles create a flexible, modular, and reusable system that is easy to understand and extend. By using abstract classes, inheritance, encapsulation, and polymorphism, the code is well-organized and promotes separation of concerns, making it easy to add new types of employees or modify existing ones.
