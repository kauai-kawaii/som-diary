"use client";

import React, { useState } from "react";
import ToolOptions from "../../get-tool-tips"; // Import ToolOptions component

// Define months by every four months
const firstFourMonths = [" 1 ", "2", "3", "4"];
const secondFourMonths = ["5", "6", "7", "8"];
const thirdFourMonths = ["9", "10", "11", "12"];

const years = [2021, 2022, 2023, 2024, 2025, 2026, 2027];

export default function MonthPicker() {
  const [selectedMonth, setSelectedMonth] = useState(new Date().getMonth() + 1);
  const [selectedYear, setSelectedYear] = useState("");

  const handleMonthSelect = (month) => {
    setSelectedMonth(month);
  };

  const handleYearClick = (selectedYear) => {
    setSelectedYear(selectedYear);
  };

  return (
    <>
      <ToolOptions
        content={
          <div className="w-32">
            <div className="flex grid-rows-4 justify-between">
              {firstFourMonths.map((month, index) => (
                <div
                  key={index}
                  onClick={() => handleMonthSelect(month)}
                  style={{ padding: "5px", cursor: "pointer" }}
                  className="content-center"
                >
                  {month}
                </div>
              ))}
            </div>
            <div className="flex grid-rows-4 justify-between">
              {secondFourMonths.map((month, index) => (
                <div
                  key={index}
                  onClick={() => handleMonthSelect(month)}
                  style={{ padding: "5px", cursor: "pointer" }}
                  className="content-center"
                >
                  {month}
                </div>
              ))}
            </div>
            <div className="flex grid-rows-4 justify-between">
              {thirdFourMonths.map((month, index) => (
                <div
                  key={index}
                  onClick={() => handleMonthSelect(month)}
                  style={{ padding: "5px", cursor: "pointer" }}
                  className="content-center"
                >
                  {month}
                </div>
              ))}
            </div>
          </div>
        }
      >
        <button className="rounded-full ml-4 inline-flex justify-center gap-x-1.5 bg-white px-3 py-2 text-sm font-semibold text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50">
          {selectedMonth}
        </button>
      </ToolOptions>
    </>
  );
}
