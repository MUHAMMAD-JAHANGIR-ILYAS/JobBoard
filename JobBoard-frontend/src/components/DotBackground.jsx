'use client';
import DotGrid from "./Backgrounds/DotGrid/DotGrid";

const DotBackground = ({ children }) => {
  return (
    <div className="fixed inset-0 w-full h-full overflow-hidden ">
      <DotGrid
       dotSize={17}
       gap={40}
       baseColor="#261E36"
       activeColor="#512DF9"
       proximity={250}
       speedTrigger={250}
       shockRadius={200}
       shockStrength={10}
       maxSpeed={5000}
       resistance={1000}
       returnDuration={3.0}
       className="absolute inset-0 -z-10"
/>
      <div className="relative z-10 h-full flex items-center justify-center">
        {children}
      </div>
    </div>
  );
};

export default DotBackground;
