import React, { useState } from "react";

export default function ToolOptions({ content, children, onClose }) {
  const [isTooltipVisible, setTooltipVisible] = useState(false);

  return (
    <>
      <div style={{ position: "relative" }}>
        <span onClick={() => setTooltipVisible(true)}>{children}</span>

        {isTooltipVisible && (
          <div
            style={{
              background: "#fff",
              position: "fixed",
              display: "inline-block",
              padding: "10px",
            }}
            className="block rounded-md border-0 py-2 text-blue-900 shadow-sm ring-1 ring-inset ring-gray-300  focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          >
            <div style={{ display: "flex" }}>
              {content}
              <button
                style={{ cursor: "pointer" }}
                className="ml-3"
                onClick={() => {
                  setTooltipVisible(false);

                  onClose && onClose();
                }}
              >
                X
              </button>
            </div>
          </div>
        )}
      </div>
    </>
  );
}
