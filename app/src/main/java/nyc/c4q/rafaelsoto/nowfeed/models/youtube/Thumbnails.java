package nyc.c4q.rafaelsoto.nowfeed.models.youtube;

/**
 * Created by Danny on 11/11/2016.
 */

public class Thumbnails {

    private Default _default;
    private Medium medium;
    private High high;

    /**
     *
     * @return
     * The _default
     */
    public Default getDefault() {
        return _default;
    }

    /**
     *
     * @param _default
     * The default
     */
    public void setDefault(Default _default) {
        this._default = _default;
    }

    /**
     *
     * @return
     * The medium
     */
    public Medium getMedium() {
        return medium;
    }

    /**
     *
     * @param medium
     * The medium
     */
    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    /**
     *
     * @return
     * The high
     */
    public High getHigh() {
        return high;
    }

    /**
     *
     * @param high
     * The high
     */
    public void setHigh(High high) {
        this.high = high;
    }

}