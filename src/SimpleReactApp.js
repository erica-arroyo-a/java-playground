import React, { useState } from "react";
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";

/**
It manages a list of employees, allowing users to add new ones dynamically
**/

export default function EmployeeManager() {
  const [employees, setEmployees] = useState([
    { id: 1, name: "Alice Johnson", role: "Engineer" },
    { id: 2, name: "Bob Smith", role: "Designer" },
  ]);

  const addEmployee = () => {
    const newEmployee = {
      id: employees.length + 1,
      name: `Employee ${employees.length + 1}`,
      role: "New Hire",
    };
    setEmployees([...employees, newEmployee]);
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen p-4">
      <Card className="p-6 text-center w-96">
        <CardContent>
          <h1 className="text-xl font-bold">Employee Manager</h1>
          <ul className="mt-4 text-left">
            {employees.map((emp) => (
              <li key={emp.id} className="border-b py-2">
                {emp.name} - {emp.role}
              </li>
            ))}
          </ul>
          <Button onClick={addEmployee} className="mt-4">Add Employee</Button>
        </CardContent>
      </Card>
    </div>
  );
}
