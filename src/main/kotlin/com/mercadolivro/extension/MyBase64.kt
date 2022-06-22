package com.mercadolivro.extension

object MyBase64 {
    private val ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray()
    private val toInt = IntArray(128)

    init {
        for (i in ALPHABET.indices) {
            toInt[ALPHABET[i].toInt()] = i
        }
    }

    /**
     * Translates the specified byte array into Base64 string.
     *
     * @param buf the byte array (not null)
     * @return the translated Base64 string (not null)
     */
    fun encode(buf: ByteArray): String {
        val size = buf.size
        val ar = CharArray((size + 2) / 3 * 4)
        var a = 0
        var i = 0
        while (i < size) {
            val b0 = buf[i++]
            val b1 = if (i < size) buf[i++] else 0
            val b2 = if (i < size) buf[i++] else 0
            val mask = 0x3F
            ar[a++] = ALPHABET[b0.toInt() shr 2 and mask]
            ar[a++] = ALPHABET[b0.toInt() shl 4 or (b1.toInt() and 0xFF shr 4) and mask]
            ar[a++] = ALPHABET[b1.toInt() shl 2 or (b2.toInt() and 0xFF shr 6) and mask]
            ar[a++] = ALPHABET[b2.toInt() and mask]
        }
        when (size % 3) {
            1 -> {
                ar[--a] = '='
                ar[--a] = '='
            }
            2 -> ar[--a] = '='
        }
        return String(ar)
    }

    /**
     * Translates the specified Base64 string into a byte array.
     *
     * @param s the Base64 string (not null)
     * @return the byte array (not null)
     */
    fun decode(s: String): String {
        val delta = if (s.endsWith("==")) 2 else if (s.endsWith("=")) 1 else 0
        val buffer = ByteArray(s.length * 3 / 4 - delta)
        val mask = 0xFF
        var index = 0
        var i = 0
        while (i < s.length) {
            val c0 = toInt[s[i].toInt()]
            val c1 = toInt[s[i + 1].toInt()]
            buffer[index++] = (c0 shl 2 or (c1 shr 4) and mask).toByte()
            if (index >= buffer.size) {
                return String(buffer)
            }
            val c2 = toInt[s[i + 2].toInt()]
            buffer[index++] = (c1 shl 4 or (c2 shr 2) and mask).toByte()
            if (index >= buffer.size) {
                return String(buffer)
            }
            val c3 = toInt[s[i + 3].toInt()]
            buffer[index++] = (c2 shl 6 or c3 and mask).toByte()
            i += 4
        }
        return String(buffer)
    }

    fun String.isBase64(): Boolean {
        return try {
            decode(this)
            true
        }
        catch (ex : Exception)
        {
            false
        }
    }
}