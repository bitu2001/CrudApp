import { useEffect, useState } from "react";
import axios from "axios";

function Data() {
  const [allEmployee, setEmployee] = useState([]);

  const fetchData = async () => {
    try {
      const response = await axios.get("http://localhost:8090/api/v1/employee/getAllEmployee");
      if (response.status === 200) {
        console.log(response);
        setEmployee(response.data);
      }
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <>
      {allEmployee.length > 0 ? (
        <table className="table">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">First</th>
              <th scope="col">Email</th>
              <th scope="col">Password</th>
            </tr>
          </thead>
          <tbody>
            {allEmployee.map((employee, index) => (
              <tr key={index}>
                <th scope="row">{employee.id}</th>
                <td>{employee.fullname}</td>
                <td>{employee.email}</td>
                <td>{employee.password}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No Data Available</p>
      )}
    </>
  );
}

export default Data;
