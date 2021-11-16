package com.citysight.entities;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity

@Table(name="Reviews")

public class Review{

    @Id
    @Column(name="review_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int reviewId;

   /* @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;*/

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Location location;

    @NotNull
    @Length(max=10000)
    @Column(name="review")
    private String review;

    @NotNull
    @Length(max=10)
    @Column(name="ratings")
    private int ratings;

    @NotNull
    @Column(name = "active_flag", columnDefinition = "tinyint default 1")
    private boolean activeFlag = true;



    public Review() {

    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    /*public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }*/

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Review(int reviewId, Location location, String review, int ratings, boolean activeFlag) {
        this.reviewId = reviewId;
       // this.account = account;
        this.location = location;
        this.review = review;
        this.ratings = ratings;
        this.activeFlag = activeFlag;
    }
}
