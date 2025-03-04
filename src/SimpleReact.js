import React, { useState } from "react";
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";

/**
simple React web application with a counter.
It includes a card component with increment and decrement buttons using React state.
**/

export default function SimpleApp() {
  const [count, setCount] = useState(0);

  return (
    <div className="flex flex-col items-center justify-center min-h-screen p-4">
      <Card className="p-6 text-center w-80">
        <CardContent>
          <h1 className="text-xl font-bold">Simple React App</h1>
          <p className="text-lg mt-2">Counter: {count}</p>
          <div className="flex justify-center gap-4 mt-4">
            <Button onClick={() => setCount(count + 1)}>Increment</Button>
            <Button onClick={() => setCount(count - 1)}>Decrement</Button>
          </div>
        </CardContent>
      </Card>
    </div>
  );
}
