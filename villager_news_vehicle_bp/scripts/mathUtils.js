/**
 * Math utilities for vehicle smoothing and clamping
 */

export function mathClamp(v, min, max) {
    return Math.min(max, Math.max(min, v));
}

export function smoothValue(newValue, history, factor) {
    history.push(newValue);
    if (history.length > factor) history.shift();
    return history.reduce((sum, val) => sum + val, 0) / history.length;
}

export function smoothAngle(newAngle, history, factor) {
    const lastAngle = history.length > 0 ? history[history.length - 1] : newAngle;
    let delta = newAngle - lastAngle;
    
    // Handle 180 deg wrap-around
    if (delta > 180) delta -= 360;
    if (delta < -180) delta += 360;
    
    const smoothedAngle = lastAngle + delta;
    history.push(smoothedAngle);
    if (history.length > factor) history.shift();
    
    return history.reduce((sum, angle) => sum + angle, 0) / history.length;
}
