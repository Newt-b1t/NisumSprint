import { useEffect, useRef } from 'react';

export default function PaginationObserver({ onIntersect, isLoading }) {
  const observerRef = useRef();

  useEffect(() => {
    const observer = new IntersectionObserver(([entry]) => {
      if (entry.isIntersecting && !isLoading) {
        onIntersect();
      }
    }, { threshold: 1.0 });

    if (observerRef.current) {
      observer.observe(observerRef.current);
    }

    return () => observer.disconnect();
  }, [isLoading, onIntersect]);

  return <div ref={observerRef} style={{ height: '10px' }} />;
}
