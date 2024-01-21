"use client";

import React, { useState } from "react";
import ToolOptions from "..get-tool-tips"; // Import ToolOptions component

const years = [2021, 2022, 2023, 2024, 2025, 2026, 2027];

export default function YearPicker() {
  const [selectedYear, setSelectedYear] = useState(new Date().getFullYear());

  const handleYearSelect = (year) => {
    setSelectedYear(year);
  };

  return (
    <>
      <ToolOptions
        content={
          <div className="w-32">
            {years.map((year, index) => (
              <button
                key={index}
                onClick={() => handleYearSelect(year)}
                className={`block w-full text-left px-3 py-2 rounded-md text-sm font-medium ${
                  year === selectedYear
                    ? "text-white bg-indigo-600"
                    : "text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                }`}
              >
                {year}
              </button>
            ))}
          </div>
        }
      >
        <button className="px-4 py-2 text-sm font-medium text-white bg-indigo-600 rounded-full hover:bg-indigo-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
          {selectedYear}
        </button>
      </ToolOptions>
    </>
  );
}
