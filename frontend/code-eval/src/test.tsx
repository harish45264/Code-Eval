import React, { useEffect, useState } from 'react';
import { testService } from './Api';

const Test: React.FC = () => {
  const [message, setMessage] = useState('');

  useEffect(() => {
    testService.check()
      .then(res => setMessage(res.data))
      .catch(err => setMessage('Failed to connect to backend') + err);
  }, []);

  return (
    <div className="p-4">
      <h1 className="text-xl font-bold mb-2">Backend Connection Test</h1>
      <p className="text-lg">{message}</p>
    </div>
  );
};

export default Test;
