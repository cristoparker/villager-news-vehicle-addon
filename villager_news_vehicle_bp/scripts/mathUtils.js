/**
 * Math utilities for vehicle movement, smoothing, angles, and vectors.
 */

export function mathClamp(v, min, max) {
    return Math.min(max, Math.max(min, v));
}

export function lerp(a, b, t) {
    return a + (b - a) * t;
}

export function wrapDegrees(deg) {
    let result = ((deg + 180) % 360);
    if (result < 0) result += 360;
    return result - 180;
}

export function lerpAngle(current, target, t) {
    const diff = wrapDegrees(target - current);
    return wrapDegrees(current + diff * t);
}

export function smoothValue(newValue, history, factor) {
    if (!history) return newValue;
    history.push(newValue);
    if (history.length > factor) history.shift();
    return history.reduce((sum, val) => sum + val, 0) / history.length;
}

export function smoothAngle(newAngle, history, factor) {
    if (!history) return newAngle;
    const lastAngle = history.length > 0 ? history[history.length - 1] : newAngle;
    const delta = wrapDegrees(newAngle - lastAngle);

    const smoothedAngle = lastAngle + delta;
    history.push(smoothedAngle);
    if (history.length > factor) history.shift();

    const avg = history.reduce((sum, angle) => sum + angle, 0) / history.length;
    return wrapDegrees(avg);
}

/**
 * Calculates local 2D forward vector from Bedrock yaw in degrees.
 * In Bedrock: 0 = South (+Z), 90 = West (-X), 180 = North (-Z), -90 = East (+X).
 */
export function getForwardVector(yaw) {
    const rad = -yaw * (Math.PI / 180);
    return {
        x: Math.sin(rad),
        z: Math.cos(rad)
    };
}

/**
 * Calculates local 2D right (strafe) vector from Bedrock yaw.
 * Right is 90° clockwise from forward.
 */
export function getRightVector(yaw) {
    const rad = -yaw * (Math.PI / 180);
    return {
        x: -Math.cos(rad),
        z: Math.sin(rad)
    };
}

/**
 * Calculates Bedrock yaw angle (degrees) from 2D directional vector (x, z).
 */
export function getYawFromDirection(x, z) {
    return -Math.atan2(x, z) * (180 / Math.PI);
}

export function calculateQuickView(rotation) {
    const rad = rotation * (Math.PI / 180);
    return {
        x: Math.cos(rad + Math.PI / 2),
        z: Math.sin(rad + Math.PI / 2)
    };
}
